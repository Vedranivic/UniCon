# RMA - DZ2 - UniCon
##### *Universal Converter*

The application represents a simple universal converter i.e. a tool foor calculating the values from one unit to another in terms of length, temperature, weight and volume. The user first selects one of four types of measurement. In the following activity he selects the unit which he wants to convert from, enters the value and then the unit which he wants to convert to. On the click of a button, a new result activity is displayed with the value converted to another unit.

### The assignment and problems encountered

The assignment was to create a universal measurement units converter with minimum four types of conversions, using intents and multiple activities. The app needs to have a **main starting activity** for user to choose the conversion type, the **conversion activity** for each type of conversion with value entry and unit selection enabled and an **activity for displaying result** of conversion. The building of this faces challenges such as working with intents and passing data between activities, layout designing, conversion implementation, working with spinners etc.

### Utilised snippets/solutions/libraries/SO answers

[ButterKnife](http://jakewharton.github.io/butterknife/)

[Android Support Library: *com.android.support:design:26.1.0*](https://developer.android.com/topic/libraries/support-library/packages.html)

[SO: Material Design Button Styles](https://stackoverflow.com/questions/26346727/android-material-design-button-styles)

[SO: Populating spinner directly in layout XML file](https://stackoverflow.com/questions/4029261/populating-spinner-directly-in-the-layout-xml?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa)

### Screenshots
<div>
<img src="/screenshots/main.png" alt="Main Activity" width = "216" height = "384" />
<img src="/screenshots/len.png" alt="Conversion Activity 1" width = "216" height = "384" />
<img src="/screenshots/temp.png" alt="Conversion Activity 2" width = "216" height = "384" />
<img src="/screenshots/weight.png" alt="Conversion Activity 3" width = "216" height = "384" />
<img src="/screenshots/vol.png" alt="Conversion Activity 4" width = "216" height = "384" />
<img src="/screenshots/len_empty.png" alt="Conversion Button Click while Empty input" width = "216" height = "384" />
<img src="/screenshots/len_choose.png" alt="Conversion Choosing from Spinner" width = "216" height = "384" />
<img src="/screenshots/result.png" alt="Result Activity" width = "216" height = "384" />
</div>

### Completed/Didn't completed and reasons
I believe the app proves that all of the necessary things have been completed and successfully implemented.

1. [x] Created main activity
2. [x] Created individual conversion activities
3. [x] Created result activity
4. [x] Implemented four types of measurement conversion (length, weight, temperature and volume)
5. [x] Connected activities through intents and extras
5. [x] Applied styles to different parts of UI

### Comment (optional)
The most challenging part was to write the code for the very conversion (from one unit to another) without using too many lines of code. Also, the layout designing and theme customizing took a fair amount of time.
