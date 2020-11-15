/*
 * main implementation: use this 'C' sample to create your own application
 *
 */

#include "MPC5748G.h" /* include peripheral declarations */


int main(void)
{
	//5.1
//		unsigned int *pDesired = 0xFFFC0268;
//		*pDesired |= 0x02020000u; //OBD, PUS


//		//5.2
//		SIUL2_MSCRC10 |= 0x02020000u;
//		SIUL2_GPDO10 |= 0x01u;
//
//
//		//5.3
//		SIUL2_MSCRC10 |= 0x02020000u;
//		SIUL2_GPDO10 |= 0x01u;
//
//		int counter = 0;
//	    /* Loop forever */
//	    for(;;) {
//	    	counter++;
//	    	if(counter % 1000 == 0){
//	    		SIUL2_GPDO10 ^= 0x01u;
//	    	}
//	    }

	    //5.4
		SIUL2_MSCR10 |= 0x02020000u;
	    SIUL2_MSCR3 |= 0x00080000u;
		SIUL2_GPDO10 |= 0x01u;

	    /* Loop forever */
	    for(;;) {
	    	SIUL2_GPDO10 = ~SIUL2_GPDI3;
	    }
}
