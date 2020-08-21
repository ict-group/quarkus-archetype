package ${package}.service.rs;

import ${package}.api.service.RsRepositoryServiceV3;
import ${package}.management.AppConstants;
import ${package}.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.USERS_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class UserServiceRs extends RsRepositoryServiceV3<User, String> {

    public UserServiceRs() {
        super(User.class);
    }


    @Override
    protected String getDefaultOrderBy() {
        return " username desc";
    }


    @Override
    public PanacheQuery<User> getSearch(String orderBy) throws Exception {
        PanacheQuery<User> search;
        Sort sort = sort(orderBy);
        if (sort != null) {
            search = User.find("select a from User a", sort);
        } else {
            search = User.find("select a from User a");
        }
        if (nn("obj.username")) {
            search
                    .filter("obj.username", Parameters.with("username", get("obj.username")));
        }
        if (nn("like.username")) {
            search
                    .filter("like.username", Parameters.with("username", likeParamToLowerCase("like.username")));
        }
        if (nn("like.roles")) {
            search
                    .filter("like.roles", Parameters.with("roles", likeParamToLowerCase("like.roles")));
        }
        return search;
    }

}
