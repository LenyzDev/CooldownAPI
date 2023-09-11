# CooldownAPI for Spigot
Use this API to create and manage a list of Cooldowns, and you can use them for different functions.

### How to use this API:
* Place the CooldownAPI.java class in your project.
* To start, create a new Cooldown List using the example code below:
```Java
    @Override
    public void onEnable() {
        CooldownAPI.createCooldown("example");
    }
```
* Now with the "example" Cooldown list created to consult it, use:
```Java
    @Override
    public void onEnable() {
        CooldownAPI.createCooldown("example");

        CooldownAPI.getCooldown("example);
    }
```
* Now here you can see some uses of the API:
```Java
    @Override
    public void onEnable() {
        CooldownAPI.createCooldown("example");

        CooldownObject cooldownList = CooldownAPI.getCooldown("example");

        // Firts: user - Second: Current time - Third: Cooldown in Long (Miliseconds)
        cooldownList.addCooldown("exampleUser", System.currentTimeMillis(), 1000L)

        // Return false: The user is not on the list or the cooldown has passed.
        // Return true: The person is still within the set cooldown and must wait to exit it.
        cooldownList.checkCooldown("exampleUser")

        // Remove user from Cooldown List
        cooldownList.removeCooldown("exampleUser") 
    }
```
