### ErrorView [![](https://jitpack.io/v/DevHossamHassan/ErrorView.svg)](https://jitpack.io/#DevHossamHassan/ErrorView)

is an Android Custom view that can help you to show:
* Error view
consists of Icon, ErrorTitle and ErrorMessage. example: if there is no internet connection
<img width=250 src="https://raw.github.com/DevHossamHassan/ErrorView/master/art/device-2017-12-03-024906.png">

* Empty view
consists of Icon, ErrorTitle and ErrorMessage. example: if there is no data to be populated in a ListView or RecyclerView


### Installation:
Add this in your root build.gradle at the end of repositories:
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```gradle
	dependencies {
	        compile 'com.github.DevHossamHassan:ErrorView:v0.0.1'
	}
```

### Usage
```xml
    <com.letsgotoperfection.errorview.ErrorView
        android:id="@+id/errorView1"
        android:layout_width="match_parent"
        app:IconColor="@color/colorAccent"
        app:Icon="@drawable/ic_error_outline_black_24dp"
        android:visibility="invisible"
        android:layout_height="match_parent">

    </com.letsgotoperfection.errorview.ErrorView>
``
ToDo: 
- Add a call to action button and customization APIs
`
