# RecyclerViewSample

### What's the issue?
The issue we are seeing is that upon screen rotation the staggered grid has gaps at the top of the grid. For context, here are the repro steps for the code in this project:
1. Start with a recycler view with a staggered grid layout manager with an initial span count of 2 in portrait mode which changes to 3 spans in landscape mode. 
2. Scroll downwards in the grid such that the top few items are no longer visible 
3. Rotate your screen
4. Scroll upwards to the top of the grid
5. Observe that some of the spans/columns have empty gaps at the top

![](http://i.imgur.com/dIG7RH9.gif)

### Investigation
After investigating the source code of StaggeredGridLayoutManager we discovered that in the `applyPendingSavedState(AchorInfo anchorInfo)` method there is a check that compares the `mSpanOffsetsSize` from the saved instance state to the current span count (`mSpanCount`). The `setLine()` method, that as far as we understand it, sets the pixel offset at which the next item in a span will be placed and it's **only** called in `applyPendingSavedState()` if the `mSpanOffsetsSize` is equal to `mSpanCount`, which is not true in our case. This results in the first visible view in each span to be positioned such that its top is aligned with the top of the screen. You can look at the following screenshot to understand this point:
![](http://i.imgur.com/mbxKqmt.png)

When the views are laid out in this manner it is obvious that there will be gaps at the top the span to accommodate for this arrangement. Those are the gaps we are seeing at the end of the GIF in the 'What's the issue' section above.

### Possible solutions
The only framework supported solution we have found is to use the `GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS` gap strategy to automatically rearrange the views when the user scrolls to the top of the screens. However, we cannot use this solution because it doesn't meet our design requirements, so we have to use 'GAP_HANDLING_NONE'. 

We are ok with the views changing what spans they are in when the screen rotation happens so that there are no gaps at the top of the screen, as long as their scroll position in the grid is approximately maintained.

We are looking for alternative technical solutions that will help us meet the design requirement described above.