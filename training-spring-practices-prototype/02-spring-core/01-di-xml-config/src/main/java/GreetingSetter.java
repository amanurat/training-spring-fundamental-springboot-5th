import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingSetter {

    private String text = "default text";

    private HelloWorld helloWorld;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        GreetingSetter greetingSetter = context.getBean(GreetingSetter.class);

        System.out.println(greetingSetter.getText());

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

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}
