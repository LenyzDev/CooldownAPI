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
* Agora aqui você poderá ver alguns usos da API:
```Java
    @Override
    public void onEnable() {
        CooldownAPI.createCooldown("example");

        CooldownObject cooldownList = CooldownAPI.getCooldown("example);

        // Firts: user - Second: Current time - Third: Cooldown in Long (Miliseconds)
        cooldownList.addCooldown("exampleUser", System.currentTimeMillis(), 1000L)

        // Return false: 
        cooldownList.checkCooldown("exampleUser") 
    }
```
