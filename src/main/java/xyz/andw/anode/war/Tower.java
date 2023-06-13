package xyz.andw.anode.war;

public class Tower {
    
    private Pattern guildtower = Pattern.compile("\[([A-Z,a-z]{3,4})\] ([A-Z,a-z ]*) - ❤ ([0-9]*) \(([0-9,.]*)%\) - ☠ ([0-9]*)-([0-9]*) \(([0-9,.]*)x\)");

    public String guildTag;
    public String terrName;
    public long hp;
    public float def;
    public long dmgLo;
    public long dmgHi;
    public float atkSpeed;

    public int auraLevel;
    public int multiLevel; // TODO: add multi

    private long lastAura = 0; 
    private long auraDelaySum = 0; 
    private int auraCount = 0; 
    
    public Tower(String guildTag, String terrName, long hp, float def, long dmgLo, long dmgHi, float atkSpeed) {
        this.guildTag = guildTag;
        this.terrName = terrName;
        this.hp = hp;
        this.def = def;
        this.dmgLo = dmgLo;
        this.dmgHi = dmgHi;
        this.atkSpeed = atkSpeed;
    }

    public void didAura() {
        auraLevel = 1; // TODO: figure out a way to compute aura level from time later
        auraCount++;
        if (lastAura == 0) {
            lastAura = System.currentTimeMillis();
            return;
        }
        
        auraDelaySum += System.currentTimeMillis()-lastAura;
        lastAura = System.currentTimeMillis();
    }

    public float meanAuraDelay() {
        return auraDelaySum / auraCount;
    }

    public String toString() {
        return String.format("%s %s %dHP %.4f %d-%d %.4f", guildTag, terrName, hp, def ,dmgLo, dmgHi, atkSpeed);
    }

    // [SDU] Light Forest West Mid Tower - ❤ 300000 (10.0%) - ☠ 1000-1500 (0.5x)
    public static Tower fromBossString(String boss) {
        Matcher matcher = pattern.matcher(boss);
        
        String targetTag = ;
        String targetTerr = ;
        Long hp = ;
        float def = ;
        int dmgLo = ;
        int dmgHi = ;
        float atkSpeed = ;
        return new Tower(targetTag, targetTerr, hp, def, dmgLo, dmgHi, atkSpeed);
    }
}
