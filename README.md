Pre-work - *TodoAPP*

TodoApp is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Amanda ALCINDOR

Time spent: 9 hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **successfully add and remove items** from the todo list
* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [ ] User can **persist todo items** and retrieve them properly on app restart


There’s no new features are implemented yet.

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

https://www.dropbox.com/s/govlb72dshpuyc1/20180628_181120_edited.mp4?dl=0

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** At first sight,
I had not really liked the android studio interface, I did not find it user-friendly but now it’s almost ok. But I still have a little bit problem with the issue of automatic updates, which gives me breaks from time to time, especially when I do not have access to the internet, I often have problems with the gradle. Contrary to Eclipse NetBeans. But I get used to it.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** 
ArrayAdapter is consists of two elements- Array and Adapter. Array is a list or array of Java objects and objects can be anything like- string, integer etc. An Adapter is a collection handler that returns each item in the collection as a view. It is used for managing the items in the list (the data model or data source).
To conclude, the ArrayAdapter class can handle a list or array of Java objects as input. Every Java object is mapped to one row. By default it maps the toString() method of the object to a view in the row layout.

A convertView is a parameter that’s used strictly to increase the performance of your Adapter. When a ListView uses an Adapter to fill its rows with Views, the adapter populates each list item with a View object by calling getView() on each row. The Adapter uses the convertView as a way of recycling old View objects that are no longer being used. In this way, the ListView can send the Adapter old, "recycled" view objects that are no longer being displayed instead of instantiating an entirely new object each time the Adapter wants to display a new list item. This is the purpose of the convertView parameter.

