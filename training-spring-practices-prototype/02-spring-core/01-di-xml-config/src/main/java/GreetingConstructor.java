import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingConstructor {

    private String text = "default constructor text";

    private HelloWorld helloWorld;

    public GreetingConstructor() {
    }

    public GreetingConstructor(String text, HelloWorld helloWorld) {
        this.text = text;
        this.helloWorld = helloWorld;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        GreetingConstructor greetingConstructor = context.getBean(GreetingConstructor.class);

        System.out.println(greetingConstructor.getText());

        System.out.println("message from hello world is : "
                + greetingConstructor.getHelloWorld().getText());

    }


}
