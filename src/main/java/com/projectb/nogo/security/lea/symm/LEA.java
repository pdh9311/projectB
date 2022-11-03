package com.projectb.nogo.security.lea.symm;

import com.projectb.nogo.security.lea.BlockCipher;
import com.projectb.nogo.security.lea.engine.LeaEngine;
import com.projectb.nogo.security.lea.mac.CMac;
import com.projectb.nogo.security.lea.mode.CBCMode;
import com.projectb.nogo.security.lea.mode.CCMMode;
import com.projectb.nogo.security.lea.mode.CFBMode;
import com.projectb.nogo.security.lea.mode.CTRMode;
import com.projectb.nogo.security.lea.mode.ECBMode;
import com.projectb.nogo.security.lea.mode.GCMMode;
import com.projectb.nogo.security.lea.mode.OFBMode;

public class LEA {
	private LEA() {
		throw new AssertionError();
	}

	public static final BlockCipher getEngine() {
		return new LeaEngine();
	}

	public static final class ECB extends ECBMode {
		public ECB() {
			super(getEngine());
		}
	}

	public static final class CBC extends CBCMode {
		public CBC() {
			super(getEngine());
		}
	}

	public static final class CTR extends CTRMode {
		public CTR() {
			super(getEngine());
		}
	}

	public static final class CFB extends CFBMode {
		public CFB() {
			super(getEngine());
		}
	}

	public static final class OFB extends OFBMode {
		public OFB() {
			super(getEngine());
		}
	}

	public static final class CCM extends CCMMode {
		public CCM() {
			super(getEngine());
		}
	}

	public static final class GCM extends GCMMode {
		public GCM() {
			super(getEngine());
		}
	}

	public static final class CMAC extends CMac {
		public CMAC() {
			super(getEngine());
		}
	}

}
