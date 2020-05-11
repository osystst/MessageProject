package app.messages;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

  private SessionFactory sessionFactory;

  public MessageRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Message saveMessage(Message message) {
    Session session = sessionFactory.openSession();
    session.save(message);
    return message;
  }

  private final static Log logger = LogFactory.getLog(MessageRepository.class);

  // private NamedParameterJdbcTemplate jdbcTemplate;

  // @Autowired
  // public void setDataSource(DataSource dataSource) {
  //   this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  // }

  // public Message saveMessage(Message message) {

  //   GeneratedKeyHolder holder = new GeneratedKeyHolder();
  //   MapSqlParameterSource params = new MapSqlParameterSource();
  //   params.addValue("text", message.getText());
  //   params.addValue("createdDate", message.getCreatedDate());
  //   String insertSQL = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, :text, :createdDate)";
  //   try {
  //     this.jdbcTemplate.update(insertSQL, params, holder);
  //   } catch (DataAccessException e) {
  //     logger.error("Failed to save message", e);
  //     return null;
  //   }

    // return new Message(holder.getKey().intValue(), message.getText(), message.getCreatedDate());

    // Connection c = DataSourceUtils.getConnection(dataSource);
    
    // try {
      
    //   String insertSql = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, ?, ?)";
    //   PreparedStatement ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

    //   // SQL에 필요한 매개변수를 준비한다.
    //   ps.setString(1, message.getText());
    //   ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
    //   int rowsAffected = ps.executeUpdate();

    //   if (rowsAffected > 0) {
    //     // 새로 저장된 메시지 id 가져오기
    //     ResultSet result = ps.getGeneratedKeys();
    //     if (result.next()) {
    //       int id = result.getInt(1);
    //       return new Message(id, message.getText(), message.getCreatedDate());
    //     } else {
    //       logger.error("Failed to retrieve id. No row in result set");
    //       return null;
    //     }
    //   } else {
    //     // Insert 실패
    //     return null;
    //   }

    // } catch (SQLException ex) {
    //   logger.error("Failed to save message", ex);
    //   try {
    //     c.close();
    //   } catch (SQLException e) {
    //     logger.error("Failed to close connection", e);
    //   }
    // } finally {
    //   DataSourceUtils.releaseConnection(c, dataSource);
    // }
    // return null;
  }
}