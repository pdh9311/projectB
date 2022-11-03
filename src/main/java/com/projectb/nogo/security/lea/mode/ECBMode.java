package com.projectb.nogo.security.lea.mode;

import com.projectb.nogo.security.lea.BlockCipher;
import com.projectb.nogo.security.lea.BlockCipher.Mode;
import com.projectb.nogo.security.lea.BlockCipherModeBlock;

public class ECBMode extends BlockCipherModeBlock {

	public ECBMode(BlockCipher cipher) {
		super(cipher);
	}

	@Override
	public String getAlgorithmName() {
		return engine.getAlgorithmName() + "/ECB";
	}

	@Override
	public void init(Mode mode, byte[] mk) {
		this.mode = mode;
		engine.init(mode, mk);
	}

	@Override
	protected int processBlock(byte[] in, int inOff, byte[] out, int outOff, int outlen) {
		if (outlen != blocksize) {
			throw new IllegalArgumentException("outlen should be " + blocksize + " in " + getAlgorithmName());
		}

		if ((inOff + blocksize) > in.length) {
			throw new IllegalStateException("input data too short");
		}

		return engine.processBlock(in, inOff, out, outOff);
	}

}
