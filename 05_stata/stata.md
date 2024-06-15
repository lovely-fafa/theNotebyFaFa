画组合图

```stata
quietly kdensity gdp
graph save gdp.gph, replace

quietly kdensity tow
graph save tow.gph, replace

quietly kdensity lgdp
graph save lgdp.gph, replace

quietly kdensity ltow
graph save ltow.gph, replace

graph combine gdp.gph tow.gph lgdp.gph ltow.gph
```

