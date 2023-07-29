# Lane Closure App

The Lane Closure App is an Android application that allows users to report and view lane closures. It includes two main fragments: LaneClosureListFragment and SelectLaneClosureFragment, which can be accessed through a ViewPager.

## Part 1: MainActivity - ViewPager with Fragments

The MainActivity hosts the ViewPager, enabling users to switch between the LaneClosureListFragment and SelectLaneClosureFragment either by clicking on the tabs above or by swiping left or right on the screen.

## Part 2: LaneClosureListFragment - Displaying Reported Lane Closures

When the app is launched, the LaneClosureListFragment is displayed, showing all the previously reported lane closures. If there is no historical data available, a page will prompt the user to add a lane closure.

### Deleting Reported Data

Users can click on the delete button to remove reported data instantly from the screen.

## Part 3: SelectLaneClosureFragment - Reporting Lane Closures

In this fragment, users can report lane closures by selecting from various available types. The user can only select one item from the Types category and one item from the Statuses category. Clicking on the item will highlight it, and clicking again will deselect it.

### Saving a Report

When the user clicks on the save button, the report will be added and immediately displayed in the lane closure list. The app will automatically navigate back to the LaneClosureListFragment after saving the report.

### Validation

The user must select at least one item from either the Type or the Status category. If no items are selected, the app will return to the list fragment and display a toast message indicating a custom message.

### Canceling the Report

If the user clicks on the cancel button, clicks on the List Fragment tab, or swipes right on the screen, the app will navigate back to the LaneClosureListFragment without displaying additional alerts.

## Part 4: Landscape Mode Support

The app is fully capable of running in landscape mode, providing a seamless user experience without any issues or complications. The landscape mode layout has been designed to adapt to different screen orientations.

## Screenshots

Here are some screenshots of the app in action:
<table>
  <tr>
    <td>
      <img src="https://github.com/aymendevflutter/laneclosure/assets/132212405/e82bd867-5418-47ed-8ce0-ca80a5e309f8" width="200" alt="lan1">
    </td>
    <td>
      <img src="https://github.com/aymendevflutter/laneclosure/assets/132212405/836ca54d-d095-4a72-885c-781c3a18989d" width="200" alt="lan2">
    </td>
    <td>
      <img src="https://github.com/aymendevflutter/laneclosure/assets/132212405/83d6c355-25d9-4730-ad12-375c1b8e365a" width="200" alt="lan3">
    </td>
  </tr>
</table>



## Installation

To install the app, follow these steps:

1. Clone the repository: `git https://github.com/aymendevflutter/laneclosure.git`
2. Open the project in Android Studio.
3. Build the project and run it on an emulator or a physical Android device.


## Contributing

If you would like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b my-feature-branch`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push the changes to your fork: `git push origin my-feature-branch`
5. Create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions or suggestions, feel free to contact me:

- Email: aminfradi99@gmail.com


!
