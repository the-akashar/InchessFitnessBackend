package com.inchessFitness.webApp.repository;


import com.inchessFitness.webApp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "contact" , path = "contact")
public interface ContactRepository extends JpaRepository<Contact,Integer> {

//    private final JdbcTemplate jdbcTemplate;
//
//
//    @Autowired
//    public ContactRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    public int saveContactMsg(Contact contact){
//        String sql = "INSERT INTO contact_msg (name,mobile_num,email,goal,message,status,"+
//                "created_at,created_by) VALUES (?,?,?,?,?,?,?,?)";
//
//        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),contact.getGoal(),contact.getMessage(),contact.getStatus(),
//                contact.getCreatedAt(),contact.getCreatedBy()
//                );
//    }
//
//    public List<Contact> fingMsgWithStatus(String status){
//        String sql ="SELECT * FROM contact_msg WHERE STATUS = ?";
//        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//
//                preparedStatement.setString(1 , status);
//
//            }
//        } , new ContactRowMapper());
//    }



    List<Contact> findByStatus(String status);
}
