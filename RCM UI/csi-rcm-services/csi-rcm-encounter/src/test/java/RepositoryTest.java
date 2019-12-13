import com.csi.rcm.encounter.prognote.repository.ChiefComplaintRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ChiefComplaintRepository chiefComplaintRepository;

    @Test
    public void testFetchData(){
//        /*Test data retrieval*/
//        PNChiefComplaint chiefComplaint = chiefComplaintRepository.findByAdmissionNo(2012002943);
//        assertNotNull(chiefComplaint);
//        Iterable<PNChiefComplaint> complaints = chiefComplaintRepository.findAll();
//        int count = 0;
//        for(PNChiefComplaint c : complaints){
//            count++;
//        }
//        assertEquals(count, 2);
    }

}
