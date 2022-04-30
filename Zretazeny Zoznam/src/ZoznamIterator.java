public interface ZoznamIterator {

	Object dalsi();
	
	boolean existujeDalsiPrvok();
	
	void pridaj(Object prvok);
	
	void zmaz();
	
	void nastav(Object prvok);
}
