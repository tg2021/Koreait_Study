package sec06.ch07;

public class InterfaceExam {

	public static void main(String[] args) {
		RemoteControl rc1 = new LGTv();
		RemoteControl rc2 = new SamsungTv();
		
		rc1.volumeUp();
		rc2.volumeUp();
		
		rc1.chkVolume();
		rc2.chkVolume();
		
		/*
		LGTv tv1 = new LGTv();
		RemoteControl rc = tv1;
		//rc.welcome();
		rc.volumeUp();
		tv1.volumeUp();
		rc.volumeDown();
		rc.chkVolume();
		*/
		
	}

}
