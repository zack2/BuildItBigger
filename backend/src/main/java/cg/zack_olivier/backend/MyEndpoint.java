/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package cg.zack_olivier.backend;

import com.example.ZackJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.zack_olivier.cg",
                ownerName = "backend.zack_olivier.cg",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
//    @ApiMethod(name = "sayHi")
//    public MyBean sayHi(@Named("name") String name) {
//        MyBean response = new MyBean();
//        response.setData("Hi, " + name);
//
//        return response;
//    }

    /** A simple endpoint method which says joke */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke() {
        MyBean response = new MyBean();
        ZackJokes zackJokes = new ZackJokes();
        response.setData(zackJokes.getZackJoke());

        return response;
    }

}
