package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Logger;

public class Frame {
	private String mMetadata;
	private String mFrameName;
	private int mShot;
	private int mStart;
	private int mFinished;
	private int mFrameNumber;
	private String mSematicOfFrame;
	
	
	public Frame(String fileNameString, String semanticOfFrame){
		this.mFrameName = fileNameString;
		this.mSematicOfFrame = semanticOfFrame;
	}
	public Frame(){
		this.setFrameName("");
		this.setSematicOfFrame("");
		this.setShot(this.setStart(this.setFinished(0)));
	}
	
	public Frame(String name, int shot, int start, int finished, String semanticOfFrame){
		this.setFrameName(name);
		this.setShot(shot);
		this.setStart(start);
		this.setFinished(finished);
		this.setSematicOfFrame(semanticOfFrame);
	}
	
	public boolean decodeFrame(String fileFrame){
		String parttern = "^(.*?)#shot_(.*?)#(.*?)_(.*?)#frame_(.*?).jpg";
        Pattern r = Pattern.compile(parttern);
        Matcher m = r.matcher(fileFrame);
        if (m.find( )) {
            setFrameName(m.group(1));
            setShot(Integer.valueOf(m.group(2)));
            setStart(Integer.valueOf(m.group(3)));
            setFinished(Integer.valueOf(m.group(4)));
            setFrameNumber(Integer.valueOf(m.group(5)));
            return true;
            
        }
        return false;
	}

	public int getFrameNumber() {
		return mFrameNumber;
	}

	public void setFrameNumber(int mFrameNumber) {
		this.mFrameNumber = mFrameNumber;
	}

	public int getFinished() {
		return mFinished;
	}

	public int setFinished(int mFinished) {
		this.mFinished = mFinished;
		return mFinished;
	}

	public int getStart() {
		return mStart;
	}

	public int setStart(int mStart) {
		this.mStart = mStart;
		return mStart;
	}

	public int getShot() {
		return mShot;
	}

	public void setShot(int mShot) {
		this.mShot = mShot;
	}

	public String getFrameName() {
		return mFrameName;
	}

	public void setFrameName(String mFrameName) {
		this.mFrameName = mFrameName;
	}

	public String getMetadata() {
		return mMetadata;
	}

	public void setmMetadata(String mMetadata) {
		this.mMetadata = mMetadata;
	}

	public String getSematicOfFrame() {
		return mSematicOfFrame;
	}

	public void setSematicOfFrame(String mSematicOfFrame) {
		this.mSematicOfFrame = mSematicOfFrame;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mFrameName;
	}
}	
