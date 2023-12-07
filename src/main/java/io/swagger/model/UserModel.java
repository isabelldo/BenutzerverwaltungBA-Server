package io.swagger.model;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * UserModel
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-16T10:27:40.080379021Z[GMT]")

@Document("users")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserModel {
  @Id //to use generated _id by MongoDB
  @JsonProperty("_id")
  private String id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @DBRef
  @JsonProperty("role")
  private List<Role> role;

  @JsonProperty("email")
  private String email;

  @JsonProperty("fullName")
  private String fullName;

}
