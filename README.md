# ActivityTransition

Examples of activity transitions

This project shows the possibilities of activity transition with Lollipop.
All the examples that will follow can be done either through java code, either through xml. The project code contains both but the examples are from the xml version.

The code is explained clearly on the [Android developers website](https://developer.android.com/training/material/animations.html#Transitions).

To get a xml implementation :
__style.xml__
```xml
<!-- windowActivityTransitions is not needed if the app theme extends "Theme.Material" and its children -->
<item name="android:windowActivityTransitions">true</item>
<item name="android:windowEnterTransition">@transition/explode</item>
<item name="android:windowExitTransition">@transition/explode</item>
```
Then you should define you transition in a *transition* folder inside of the *res* folder :
__explode.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Exclude the status bar and the navigation bar from the animation -->
    <targets>
        <target android:excludeId="@android:id/statusBarBackground"/>
        <target android:excludeId="@android:id/navigationBarBackground"/>
    </targets>
    <explode/>
</transitionSet>
```
To get a java code implementation:
__TransitionActivity.java__
```java
// requestFeature() is not needed if the app theme extends "Theme.Material" and its children
getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
getWindow().setEnterTransition(new Explode());
getWindow().setExitTransition(new Explode());
```
To activate the transition when changing screen, you should add this piece of code in the parent activity :
```java
ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
startActivity(new Intent(), options.toBundle());
```

## Explode
This only example shows the xml version and the java code version because the rendering is different.

Simple image | Image and Text | With a fragment
------------ | ------------- | -------------
![Demo](images/githubactivitytransitionexplode.gif) | ![Demo](images/githubactivitytransitionexplodeimageandtext2.gif) | ![Demo](images/githubactivitytransitionexplodefragment.gif)

For the image and text example, I used the java code to implement the transition, and I defined a transition only for the parent activity while the target one uses the default one, which give a different effect than the first example.

## Slide

Simple image | Image and Text | With a fragment
------------ | ------------- | -------------
![Demo](images/githubactivitytransitionslide.gif) | ![Demo](images/githubactivitytransitionslideimageandtext.gif) |![Demo](images/githubactivitytransitionslidefragment.gif) 

By default, it slides to the bottom. But it can be customized: 

__XML__
```xml
<slide android:slideEdge="bottom|left|end|right|start|top"/>
```
__Java__
```java
Slide slide = new Slide();
slide.setSlideEdge(Gravity.BOTTOM|Gravity.LEFT|...);
getWindow().setEnterTransition(slide);
getWindow().setExitTransition(slide);
```

On the image and text example, the first activity slides to the left while the target one slides to the right.

## Fade

![Demo](images/githubactivitytransitionfade.gif)

This effect is also the default effect and can be realised by calling `AutoTransition`.

## Unknown issue

There is an unexplicable bug for the fragment example. If the textview does not have a transition name, the transition won't apply to the fragment content when entering the screen but the exit will done correctly. However the bug happened with devices running on version 5.0.x but did not happen on 5.1.x devices
