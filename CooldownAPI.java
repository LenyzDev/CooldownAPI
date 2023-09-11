package com.example;

import java.util.HashMap;

public class CooldownAPI {

    private static HashMap<String, CooldownObject> Storage = new HashMap<>();

    public void createCooldown(String id){
        Storage.put(id, new CooldownObject());
        System.out.println("[Debug] CooldownAPI - The Cooldown List '"+id+"' has created.");
    }

    public static CooldownObject getCooldown(String id){
        return Storage.get(id);
    }

    public static boolean containsCooldown(String id){
        return Storage.containsKey(id);
    }

    public static HashMap<String, CooldownObject> returnHash(){
        return Storage;
    }

    public class CooldownObject {
        private HashMap<String, TimeObject> cooldowns;

        public CooldownObject() {
            cooldowns = new HashMap();
        }

        public void addCooldown(String id, long createdTime, long delay) {
            cooldowns.put(id, new TimeObject(createdTime, delay));
        }

        public void removeCooldown(String id) {
            cooldowns.remove(id);
        }

        public TimeObject getCooldown(String id) {
            return cooldowns.get(id);
        }

        public boolean checkCooldown(String id) { // False = ready for use
            if(cooldowns.containsKey(id)){
                if(!cooldowns.get(id).isEnded()){
                    return true;
                }
            }
            return false;
        }
    }

    public class TimeObject {

        private Long createdTime;
        private Long delay;

        public TimeObject(Long createdTime, Long delay){
            this.createdTime = createdTime;
            this.delay = delay;
        }

        public Long getCreatedTime() {
            return this.createdTime;
        }

        public void setCreatedTime(Long createdTime) {
            this.createdTime = createdTime;
        }

        public Long getDelay() {
            return delay;
        }

        public void setDelay(Long delay) {
            this.delay = delay;
        }

        public boolean isEnded(){
            if(System.currentTimeMillis() - this.createdTime >= this.delay){
                return true;
            }else {
                return false;
            }
        }

        public Long delayPassed(){
            return (System.currentTimeMillis() - this.createdTime);
        }

        public Long delayRemaining(){
            return this.delay - (System.currentTimeMillis() - this.createdTime);
        }
    }
}
