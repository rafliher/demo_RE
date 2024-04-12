from PIL import Image, ImageDraw

# Define the file path
file_path = '../saveFile.txt'

# Open the file for reading
with open(file_path, 'r') as reader:
    # Create an empty list to hold pixel data
    pixel_data = []

    # Read each line from the file
    for line in reader:
        # Split the line into individual values
        values = line.strip().split(' ')
        
        # Convert the values to integers and append to pixel_data
        pixel_data.extend([int(val) for val in values])

    # Define canvas dimensions (width and height)
    width = 840  # Specify your canvas width
    height = 160  # Specify your canvas height

    # Create a new image with the specified dimensions
    canvas_image = Image.new('RGB', (width, height))

    # Create a draw object to manipulate the image
    draw = ImageDraw.Draw(canvas_image)

    # Loop through each pixel position
    index = 0
    for y in range(height):
        for x in range(width):
            # Extract RGB values from pixel_data
            red = pixel_data[index]
            green = pixel_data[index + 1]
            blue = pixel_data[index + 2]
            
            # Draw the pixel on the canvas image
            draw.point((x, y), fill=(red, green, blue))

            # Increment index by 3 to move to the next pixel data
            index += 3

    # Display the canvas image
    canvas_image.show()
