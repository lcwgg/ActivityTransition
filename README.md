# ActivityTransition

Examples of activity transitions

This project shows the possibilities of activity transition with Lollipop.
All the examples that will follow can be done either through java code, either through xml. The project code contains both but the examples are from the xml version.

The code is explained clearly on the [Android developers website](https://developer.android.com/training/material/animations.html#Transitions).

## Explode
This only example shows the xml version and the java code version because the rendering is different.

XML | Java
------------ | -------------
![Demo](images/githubactivitytransitionexplode.gif) | ![Demo](images/githubactivitytransitionexplode2.gif)

I cannot explain yet this difference and I was not able to customize the explode transtion to have the one from xml in Java code and vice versa.

## Slide

![Demo](images/githubactivitytransitionslide.gif)

By default, it slides to the bottom. But it can be customized: 

__XML__
```
<slide android:slideEdge="bottom|left|end|right|start|top"/>
```
__Java__
```
Slide slide = new Slide();
slide.setSlideEdge(Gravity.BOTTOM|Gravity.LEFT|...);
```

## Fade

![Demo](images/githubactivitytransitionfade.gif)

This effect is also the default effect and can be realised by calling AutoTransition.
