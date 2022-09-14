# PNPscript
PNPscript - ProdigyPNP's upcoming programming language, designed for hacking Prodigy.

THIS IS IN EARLY DEVELOPMENT. DON'T BOTHER TRYING TO ACTUALLY LIKE USE THIS RN

## Why PNPscript?
First of all, it should let us, Alphas of ProdigyPNP, quickly prototype ideas for new hacks without... doing the webpack _every time_.

Also, maybe skids could write their own hacks instead of constantly bugging us?



## Example: Set Gold

PNPscript:
Convenient gold accessor and Toast notification.
Always checks to make sure that gold is not over 10,000,000 at compile time.
```pnps
me.gold = 100000
~ Success ~ Set Gold to 100,000 ~ success
```

TypeScript/JavaScript:
We have to wrap it in async.
To use this, we must first manually add Toast fills.
We also have to add an extra line of code to check for the gold amount.
```typescript
(async () => {
    const gold = 100000;
    if (gold > 10000000) return Toast.fire("Error", "Cannot have more than 10,000,000 gold.", "error");
    _.player.data.gold = gold;
    return Toast.fire("Success!", `Set Gold to 100,000.`, "success");
})();
```


