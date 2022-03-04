package mx.aplazo.backend_test.juliosansossio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interest")
public class Interest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String request;
  private String response;

  public Interest(String request, String response) {
    this.request = request;
    this.response = response;
  }

  public Interest() {
  }

  public static Interest create(String request, String response) {
    return new Interest(request, response);
  }

  public Long getId() {
    return id;
  }

  public String getRequest() {
    return request;
  }

  public String getResponse() {
    return response;
  }
}