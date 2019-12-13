package com.csi.vidaplus.rcm.masterdata.service.impl;


import com.csi.vidaplus.rcm.masterdata.repository.SequenceRepository;
import com.csi.vidaplus.rcm.masterdata.service.SequenceGeneratorService;
import com.csi.vidaplus.rcm.masterdata.util.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
/**
 * This is the implementation of sequence generator builder
 *
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

    @Autowired
    private SequenceRepository sequenceRepository;
    @Autowired
    private MongoOperations mongoOperations;

    /**
     * Get next sequence number of a collection. if collection not exists
     * create a collection set sequence to 0
     * @param collection
     * @return next sequence of a collection
     */
    public int getNextSequence(String collection) {

        Query query = new Query(Criteria.where("_id").is(collection));
        Counter counter=mongoOperations.findOne(query,Counter.class);
        if(counter==null){
            createOrResetSequence(collection,0);
            getNextSequence(collection);
        }else{
            counter = mongoOperations.findAndModify(
                    query, new Update().inc("seq", 1),
                    FindAndModifyOptions.options().returnNew(true),
                    Counter.class);
        }
        return counter.getSeq();
    }

    @Override
    public void createOrResetSequence(String collection, int number) {
        sequenceRepository.save(new Counter(collection, number));
    }
}