// public class ExtendedLogger extends Logger { } // ❌ Error: Cannot subclass final class
*/
*/

#### `MainLogger.java`
```java
import java.util.Scanner;

public class MainLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = new Logger();

        System.out.print("Enter a message to log: ");
        String msg = sc.nextLine();

        logger.logMessage(msg);
    }
}
