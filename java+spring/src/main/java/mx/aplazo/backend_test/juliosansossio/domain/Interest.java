package mx.aplazo.backend_test.juliosansossio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "interest")
@Data
public class Interest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(columnDefinition = "text")
  private String request;

  @Column(columnDefinition = "text")
  private String response;

  public static Interest create(String request, String response) {
    Interest interest = new Interest();
    interest.setRequest(request);
    interest.setResponse(response);
    return interest;
  }
}