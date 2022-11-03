package com.projectb.nogo.security.lea.mode;

import static com.projectb.nogo.security.lea.util.Ops.*;
import com.projectb.nogo.security.lea.BlockCipher;
import com.projectb.nogo.security.lea.BlockCipher.Mode;
import com.projectb.nogo.security.lea.BlockCipherModeStream;

public class CTRMode extends BlockCipherModeStream {

	private byte[] iv;
	private byte[] ctr;
	private byte[] block;

	public CTRMode(BlockCipher cipher) {
		super(cipher);
	}

	@Override
	public String getAlgorithmName() {
		return engine.getAlgorithmName() + "/CTR";
	}

	@Override
	public void init(Mode mode, byte[] mk, byte[] iv) {
		this.mode = mode;
		engine.init(Mode.ENCRYPT, mk);

		this.iv = iv.clone();
		ctr = new byte[blocksize];
		block = new byte[blocksize];
		reset();
	}

	@Override
	public void reset() {
		super.reset();
		System.arraycopy(iv, 0, ctr, 0, ctr.length);
	}

	@Override
	protected int processBlock(byte[] in, int inOff, byte[] out, int outOff, int outlen) {
		int length = engine.processBlock(ctr, 0, block, 0);
		addCounter();

		XOR(out, outOff, in, inOff, block, 0, outlen);

		return length;
	}

	private void addCounter() {
		for (int i = ctr.length - 1; i >= 0; --i) {
			if (++ctr[i] != 0) {
				break;
			}
		}
	}

}
