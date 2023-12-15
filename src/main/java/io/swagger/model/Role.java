package io.swagger.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
@Getter
@Setter
public class Role {
    @Id
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Role{name='" + name + "'}";
    }
}
