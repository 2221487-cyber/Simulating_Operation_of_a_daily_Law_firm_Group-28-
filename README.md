# Law Firm Management System

A comprehensive Java desktop application built with JavaFX and Scene Builder for managing law firm operations. The system supports two user roles: **Lawyer** and **Legal Researcher**, each with their own dashboard and eight specialized functional pages.

## Features

### Authentication
- Single login page for both user types
- Role-based redirection to appropriate dashboards
- Secure user authentication

### Lawyer Features (8 Goals)
1. **Create New Case File** - Create and store new case entries with client information
2. **Update Case Status** - Update case status (Open, In Progress, Closed)
3. **Manage Hearing Dates** - Assign and update upcoming hearing dates
4. **Upload Case Documents** - Attach document metadata to cases
5. **View Client Details** - Display client information and case history
6. **Generate Case Progress Report** - Generate comprehensive case summaries
7. **Track Billing and Payments** - Manage billing information and payment tracking
8. **Close Case** - Finalize and close cases (making them read-only)

### Legal Researcher Features (8 Goals)
1. **Create Research Record** - Create new research records with topics, keywords, and references
2. **Search Legal Precedents** - Search precedents by keyword, court, or year
3. **Save Precedent to Library** - Save precedents to personal library
4. **Generate Research Summary** - Create and edit research summaries
5. **Compare Two Precedents** - Side-by-side comparison of precedents
6. **Export Research Report** - Generate full research reports
7. **Edit Previous Research Record** - Update existing research records
8. **View Research History** - View all previous research records

## Project Structure

```
law-firm-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── lawfirm/
│   │   │           ├── LawFirmApplication.java (Main entry point)
│   │   │           ├── controllers/
│   │   │           │   ├── LoginController.java
│   │   │           │   ├── LawyerDashboardController.java
│   │   │           │   ├── ResearcherDashboardController.java
│   │   │           │   ├── lawyer/ (8 controllers)
│   │   │           │   └── researcher/ (8 controllers)
│   │   │           ├── models/ (All data models)
│   │   │           └── utils/ (DataStorage, PageNavigator)
│   │   └── resources/
│   │       └── fxml/
│   │           ├── LoginPage.fxml
│   │           ├── LawyerDashboard.fxml
│   │           ├── ResearcherDashboard.fxml
│   │           ├── lawyer/ (8 FXML files)
│   │           └── researcher/ (8 FXML files)
├── pom.xml
└── README.md
```

## Prerequisites

- **Java Development Kit (JDK) 11 or higher**
- **Maven 3.6+** (for dependency management)
- **IntelliJ IDEA** (recommended IDE)
- **JavaFX Scene Builder** (for visual FXML editing - optional)

## Setup Instructions

### 1. Clone or Download the Project
Extract the project to your desired location.

### 2. Open in IntelliJ IDEA
1. Open IntelliJ IDEA
2. Select `File` → `Open`
3. Navigate to the project directory and select it
4. IntelliJ will automatically detect the Maven project and import dependencies

### 3. Configure JavaFX
The project uses JavaFX 17.0.2. Maven will automatically download the dependencies when you build the project.

### 4. Build the Project
In IntelliJ IDEA:
- Right-click on `pom.xml` → `Maven` → `Reload Project`
- Wait for dependencies to download
- Build the project: `Build` → `Build Project`

### 5. Run the Application
1. Navigate to `src/main/java/com/lawfirm/LawFirmApplication.java`
2. Right-click → `Run 'LawFirmApplication.main()'`
   OR
   Use the Maven plugin:
   ```bash
   mvn clean javafx:run
   ```

## Default Login Credentials

The application comes with sample data pre-loaded:

### Lawyer Account
- **Email:** lawyer@lawfirm.com
- **Password:** password

### Legal Researcher Account
- **Email:** researcher@lawfirm.com
- **Password:** password

## Using Scene Builder (Optional)

To visually edit FXML files:

1. **Install Scene Builder**
   - Download from: https://gluonhq.com/products/scene-builder/
   - Install Scene Builder

2. **Configure Scene Builder in IntelliJ**
   - Go to `File` → `Settings` → `Languages & Frameworks` → `JavaFX`
   - Set the path to Scene Builder executable

3. **Open FXML Files**
   - Right-click any `.fxml` file → `Open in Scene Builder`
   - Make your visual edits
   - Save and the changes will be reflected in IntelliJ

## Application Navigation

### Login Flow
1. Application starts at the login page
2. Enter credentials and click "Login"
3. Based on role, user is redirected to their dashboard

### Dashboard Navigation
- Each dashboard contains 8 buttons, one for each goal page
- Click any button to navigate to the corresponding functional page
- Use "Back to Dashboard" button on any page to return
- Use "Logout" button to return to login page

## Data Storage

The application uses in-memory data storage (`DataStorage` class). All data is stored during the application session and will be lost when the application is closed. Sample data is initialized when the application starts.

To persist data:
- Implement file-based storage (JSON, XML, or database)
- Modify the `DataStorage` class to save/load data from files
- Add serialization/deserialization methods

## Model Classes

The application includes the following model classes:
- `User` - Base user class
- `Lawyer` - Extends User, contains bar ID, cases, and clients
- `LegalResearcher` - Extends User, contains employee ID, research records, and precedents
- `CaseFile` - Case information, status, hearing dates, documents
- `Client` - Client personal details and case history
- `ResearchRecord` - Research topics, keywords, references, summaries
- `Precedent` - Legal precedent information
- `Document` - Document metadata
- `Billing` - Billing and payment information

## Troubleshooting

### Issue: Application won't start
- Ensure JDK 11+ is installed and configured
- Check that Maven dependencies are downloaded
- Verify JavaFX modules are available

### Issue: FXML files not found
- Ensure FXML files are in `src/main/resources/fxml/`
- Check that resources are marked as "Resources Root" in IntelliJ
- Verify file paths in controllers match actual file locations

### Issue: Scene Builder not opening
- Verify Scene Builder installation path
- Check IntelliJ Scene Builder configuration
- Try opening Scene Builder manually first

## Development Notes

- All pages are designed using FXML (compatible with Scene Builder)
- Each page has a dedicated controller class
- Navigation is handled through the `PageNavigator` utility class
- Data is managed through the singleton `DataStorage` class
- The application follows MVC (Model-View-Controller) architecture

## Future Enhancements

Potential improvements:
- Database integration (MySQL, PostgreSQL)
- File upload/download functionality
- Advanced search and filtering
- Report generation (PDF export)
- Email notifications
- Multi-user concurrent access
- Data persistence across sessions

## License

This project is created for educational purposes.

## Support

For issues or questions:
1. Check the troubleshooting section
2. Review the code comments
3. Verify all prerequisites are met

---

**Note:** This is a desktop application. Ensure you have JavaFX runtime libraries available. The Maven configuration handles this automatically, but if running from command line, you may need to add JavaFX modules to the module path.

