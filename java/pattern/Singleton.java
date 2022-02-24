package pattern;

public class Singleton {

	//private static final Singleton instance = new Singleton();
	private static  Singleton  instance;
	// private constructor to avoid client applications to use constructor
	private Singleton() {
	}

//	public static Singleton getInstance() {
//		return instance;
//	}
	// 2nd Way Double checked locking
	public static Singleton getInstance2() {
		if(instance ==null) {
			synchronized (Singleton.class) {
				if(instance==null) {
					instance= new Singleton();
				}
			}
		}
		return instance;
	}
	//3rd Way Bill Pugh
	// When a class Singleton class is loaded SingletonHelper class is not loaded into memory only
	// when someone calls getInstance method the class gets loaded.
	 // 1. Private Construction

		private static class SingletonHelper{
			private static final Singleton INSTANCE= new Singleton();
		}
//		public static Singleton getInstance() {
//		return SingletonHelper.INSTANCE;
//	}
		
		//ENUM SINGLETON  . Little inflexible but handles reflection breaking point. Can't do lazy initialization
		// public enum Singeton{
			//INSTANCE;
		
		//}
		
		// implement readResolve() to overcome Serialization creating new instance each time
		protected Object getResolve() {
			return getInstance();
		}
		
}
