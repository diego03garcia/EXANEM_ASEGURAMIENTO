import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

public class CalculadoraTest {
    @Test
    void dividir_debe_ser_cociente() throws Exception {
        Class<?> cls = Calculadora.class;
        Object instance = null;
        // Try to instantiate if constructor exists
        try {
            Constructor<?> c = cls.getDeclaredConstructor();
            c.setAccessible(true);
            instance = c.newInstance();
        } catch (NoSuchMethodException e) {
            // ignore, maybe static method
        }

        // locate method 'dividir' (any signature with two ints)
        Method m = null;
        for (Method mm : cls.getDeclaredMethods()) {
            if (mm.getName().equals("dividir") && mm.getParameterCount() == 2) {
                Class<?>[] p = mm.getParameterTypes();
                if ((p[0] == int.class || p[0] == Integer.class) && (p[1] == int.class || p[1] == Integer.class)) {
                    m = mm; break;
                }
            }
        }
        assertNotNull(m, "No se encontró el método dividir(int,int) en la clase Calculadora");

        Object result = m.invoke(Modifier.isStatic(m.getModifiers()) ? null : instance, 8, 4);
        double valor = (result instanceof Number) ? ((Number) result).doubleValue() : Double.parseDouble(String.valueOf(result));
        assertEquals(2.0, valor, 1e-9, "dividir(8,4) debería ser 2.0");
    }
}
