package app.resource;

import app.entity.Fruit;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/hello")
public class GreetingResource {

  @GET
  public Uni<List<Fruit>> get() {
    return Fruit.listAll(Sort.by("name"));
  }

  @GET
  @Path("/{id}")
  public Uni<Fruit> getSingle(Long id) {
    return Fruit.findById(id);
  }

  @POST
  public Uni<RestResponse<Fruit>> create(Fruit fruit) {
    return Panache.withTransaction(fruit::persist)
        .replaceWith(RestResponse.status(RestResponse.Status.CREATED, fruit));
  }
}
