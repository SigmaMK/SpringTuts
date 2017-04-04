package hello;

/**
 * Created by MKE10580 on 2017-04-04.
 */

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
     **/
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**@RequestParam binds the value of the query string parameter name into the name parameter of the greeting()
     * method. This query string parameter is explicitly marked as optional (required=true by default): if it is absent
     * in the request, the defaultValue of "World" is used.
     *
     * The implementation of the method body creates and returns a new Greeting object with id and content attributes
     * based on the next value from the counter, and formats the given name by using the greeting template.
     * **/
}
