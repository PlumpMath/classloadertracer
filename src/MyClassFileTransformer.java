import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;


public class MyClassFileTransformer implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		final java.io.PrintStream out = System.out;
		out.print(className + " loaded by " + loader + " at " +
		new java.util.Date());
		out.println(" in " + protectionDomain);
		// dump stack trace of the thread loading class
		Thread.dumpStack();
		// we just want the original .class bytes to be loaded!
		// we are not instrumenting it...
		return null;
	}

}
