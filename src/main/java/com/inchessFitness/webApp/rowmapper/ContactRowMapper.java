package com.inchessFitness.webApp.rowmapper;


import com.inchessFitness.webApp.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs ,int rowNum) throws SQLException{
        Contact contact = new Contact();
        contact.setContactId(rs.getInt("CONTACT_ID"));
        contact.setName(rs.getString("NAME"));
        contact.setEmail(rs.getString("EMAIL"));
        contact.setMobileNum(rs.getString("MOBILE_NUM"));
        contact.setMessage(rs.getString("message"));
        contact.setGoal(rs.getString("goal"));
        contact.setStatus(rs.getString("status"));

        return contact;
    }
}
