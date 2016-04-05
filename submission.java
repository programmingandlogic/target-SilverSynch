/*
 * Displays a "classic target" visual in the center of the screen.
 * This program is built with minimal hardcoding for maximum fun.
 */

// We need to import the color and graphics library, obviously.
// Color is needed to color anything at all.
import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class Target extends GraphicsProgram
{
	
	// We begin by storing the height and width we need to meet.
	// By manipulating these, we can resize the target.
	int target_width = 72;
	int target_height = 72;
	
	// We'll also store the numbers used to place our circles.
	// By manipulating these, we can move the target.
	double placement_diviser_X = 2.0;
	double placement_diviser_Y = 2.0;
	
	public void run()
	{
		
		// We create our outer circle first. Since the placement and size 
		// data will be overwritten later, it's unimportant to add real data there.
		GOval outer_circle = new GOval(0, 0, 0, 0);
		outer_circle.setFillColor(Color.RED);
		outer_circle.setFilled(true);
		outer_circle.setColor(Color.WHITE);
		
		// We create the middle circle.
		GOval middle_circle = new GOval(0, 0, 0, 0 );
		middle_circle.setFillColor(Color.WHITE);
		middle_circle.setFilled(true);
		middle_circle.setColor(Color.RED);
		
		// And finally, the inner circle.
		GOval inner_circle = new GOval(0, 0, 0, 0);
		inner_circle.setFillColor(Color.RED);
		inner_circle.setFilled(true);
		inner_circle.setColor(Color.WHITE);
		
		// All circles are then added to the canvas, displaying them in
		// correct order to make them appear as a target. They will 
		// continue to display until removed from the canvas.
		add(outer_circle);
		add(middle_circle);
		add(inner_circle);
		
		// In order for the visuals to constantly update, we must run a infinite loop.
		// We don't lock down mouse or keyboard inputs, so it's easy to destroy.
		// We also don't constantly take up more memory either
		// (since we only overwrite the data instead of making new ones)
		// so this isn't too dangerous.
		while(true)
		{
			
			// We'll avoid re-calculating these for each circle.
			double half_width = getWidth() / placement_diviser_X;
			double half_height = getHeight() / placement_diviser_Y;
			
			// We set the data for all three circles.
			// The XY-coords are the center of the screen, while the size
			// is based on the design documents. It specifies that "one inch" is
			// 72 pixels (our default for the outer circle), that the middle
			// circle is 0.65 of one inch, and the inner circle is 0.3 of
			// one inch. Since we rely on circle size for placement, we set 
			// it before the XY-coords.
			outer_circle.setSize(target_width, target_height);
			outer_circle.setLocation(half_width - (outer_circle.getWidth() / 2),
					half_height - (outer_circle.getHeight() / 2) );
			
			middle_circle.setSize( (target_width * 0.65), (target_height * 0.65) );
			middle_circle.setLocation(half_width - (middle_circle.getWidth() / 2),
					half_height - (middle_circle.getHeight() / 2) );
			
			inner_circle.setSize( (target_width * 0.3), (target_height * 0.3) );
			inner_circle.setLocation(half_width - (inner_circle.getWidth() / 2),
					half_height - (inner_circle.getHeight() / 2) );
			
		}
		
	}
	
	// Due to the use of an infinite loop, this fails to work.
	// It's possible to replace the loop with a call from a function
	// that detects the resizing of a window, but that's just about
	// going overboard at this point.
	// For now, this will be commented out.
	// TODO: Fix input bug
//	public void keyPressed (KeyEvent e)
//	{
//		
//		switch (e.getKeyCode())
//		{
//		
//		case KeyEvent.VK_UP:
//			target_height--;
//			break;
//		case KeyEvent.VK_DOWN:
//			target_height++;
//			break;
//		case KeyEvent.VK_LEFT:
//			target_width--;
//			break;
//		case KeyEvent.VK_RIGHT:
//			target_width++;
//			break;
//			
//		}
//		
//	}

}
