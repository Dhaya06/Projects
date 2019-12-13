package com.csi.vidaplus.rcm.datadictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csi.vidaplus.rcm.datadictionary.util.Counter;

/**
 * This is the repository of sequence
 *
 * @version 1.0 12 Jan 2018
 * @author Ahsan Shamsudeen
 */
public interface SequenceRepository  extends MongoRepository<Counter, Integer> {
}