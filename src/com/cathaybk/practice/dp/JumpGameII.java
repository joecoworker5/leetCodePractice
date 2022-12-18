package com.cathaybk.practice.dp;


public class JumpGame {

	public boolean canJump(int[] nums) {
        int maxJumpSofar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJumpSofar >= i) {
                maxJumpSofar = Math.max(maxJumpSofar, i + nums[i]);
            }
            else {
                return false;
            }
        }

        return true;
    }

}
