        // Add a class-level variable to store the selected file path
        private String pathfilm = null;

        // Inside your createHomeAdminPanel method
        RoundedButton FilmSelectpath = new RoundedButton("Select Film Image", 10);
        FilmSelectpath.setBounds(40, 400, 70, 40);
        FilmSelectpath.setForeground(Color.red);
        FilmSelectpath.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                pathfilm = selectedFile.getAbsolutePath(); // Store the selected file path
                System.out.println(pathfilm);

                // Update the FilmPicture label with the selected image
                ImageIcon MoviePic = resizedIcon(pathfilm);
                FilmPicture.setIcon(MoviePic); // Set the icon of the JLabel
            }
        });
        InfoFilm2.add(FilmSelectpath);

        // Initialize the FilmPicture label with a placeholder or empty icon
        JLabel FilmPicture = new JLabel();
        FilmPicture.setBounds(120, 10, 300, 400);
        FilmPicture.setForeground(Color.white);
        FilmPicture.setFont(new Font("Arial", Font.PLAIN, 100));
        MoviePicture.add(FilmPicture);