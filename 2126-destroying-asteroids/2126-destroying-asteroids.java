class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currmass=mass;
        for(int i:asteroids){
            if(currmass>= i) currmass+=i;
            else return false;
        }
        return true;
    }
}