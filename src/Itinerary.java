
public class Itinerary {

	private static final int MINUTES = 60;
	
	private int hDep1, mDep1, hDep2, mDep2, hDep3, mDep3, dur1, dur2, dur3, hExam, mExam;

	public Itinerary(int hDep1,int mDep1,int hDep2, int mDep2,int hDep3,int mDep3,int dur1,int dur2, int dur3, int hExam, int mExam) {

		this.hDep1 = hDep1 * MINUTES;
		this.mDep1 = mDep1;
		this.hDep2 = hDep2 * MINUTES;
		this.mDep2 = mDep2;
		this.hDep3 = hDep3 * MINUTES;
		this.mDep3 = mDep3;
		this.dur1 = dur1;
		this.dur2 = dur2;
		this.dur3 = dur3;
		this.hExam = hExam * MINUTES;
		this.mExam = mExam;
	}

	public boolean isPossible() {

		boolean result = true;
		
		int horaPartida1 = hDep1 + mDep1;
		int horaPartida2 = hDep2 + mDep2;
		int horaPartida3 = hDep3 + mDep3;
		int horaChegada1 = horaPartida1 + dur1;
		int horaChegada2 = horaPartida2 + dur2;
		
		if(horaPartida1 < horaPartida2 && horaPartida2 < horaPartida3) {
		if(horaChegada1 >  horaPartida2 || horaChegada2 > horaPartida3)
			result = false;
		}else if(horaPartida1 > horaPartida2 && horaPartida2 < horaPartida3) {
			
			horaPartida2 = horaPartida2 + (24*60);
			horaPartida3 = horaPartida3 + (24*60);
			
			if(horaChegada1 >  horaPartida2 || horaChegada2 > horaPartida3)
				result = false;
			
		}else {
			
			horaPartida3 = horaPartida3 + (24*60);
			
			if(horaChegada1 >  horaPartida2 || horaChegada2 > horaPartida3)
				result = false;
		}
		
		return result;
	}

	public boolean isUseful() {
		
		boolean result = false;
		
		int horaPartida3 = hDep3 + mDep3;
		int horaChegadaFinal = horaPartida3 + dur3;
		int horaExame = hExam + mExam;
		
		if(horaPartida3 > horaExame) {
			
			horaExame = horaExame + (24*60);
			
			if(horaChegadaFinal <= horaExame)
				result = true;
		}else {
		if(horaChegadaFinal <= horaExame)
			result = true;
		}
		
		return result;
	}
}
