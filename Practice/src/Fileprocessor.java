public class Fileprocessor {

    public void processFile(String fileName) {
        try {
            if (fileName.endsWith(".txt")) {
                System.out.println("Processing Text File");
            } else if (fileName.endsWith(".bin")) {
                System.out.println("Processing Binary File");
            } else if (fileName.endsWith(".ser")) {
                System.out.println("Processing Serialized Object File");
            } else {
                // Unsupported type → throw custom exception
                throw new UnsupportedOperationException("Unsupported file type: " + fileName);
            }
        } 
        catch (UnsupportedOperationException e) {
            System.out.println("Warning: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Error while processing file.");
        }
        finally {
            System.out.println("Finished trying to process: " + fileName);
        }
    }

    public static void main(String[] args) {
        Fileprocessor fp = new Fileprocessor();
        fp.processFile("data.txt");   // supported
        fp.processFile("image.jpg");  // unsupported
    }
}
