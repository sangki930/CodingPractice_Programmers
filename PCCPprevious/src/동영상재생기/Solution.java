package 동영상재생기;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        long t = timeToLong(pos);
        long op_start_t = timeToLong(op_start);
        long op_end_t = timeToLong(op_end);
        for(String command : commands){
            if(op_start_t <= t && t<=op_end_t){
                t = op_end_t;
            }
            switch(command){
                case "next":
                    t  = Math.min(timeToLong(video_len), t + 10L);
                    break;
                case "prev":
                    t  = Math.max(0, t - 10L);
                    break;
            }
            if(op_start_t <= t && t<=op_end_t){
                t = op_end_t;
            }
        }

        return longToTime(t);
    }

    public long timeToLong(String time){
        String[] tmp = time.split(":");
        return Long.parseLong(tmp[0])*60L + Long.parseLong(tmp[1]);
    }

    public String longToTime(long t){
        return String.format("%02d",t/60) +":" + String.format("%02d",t%60);
    }
}