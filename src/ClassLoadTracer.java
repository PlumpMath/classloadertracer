
import java.lang.instrument.Instrumentation;

public class ClassLoadTracer {

	public static void premain(String agentArgs, Instrumentation inst) {
		inst.addTransformer(new MyClassFileTransformer());
	}
}