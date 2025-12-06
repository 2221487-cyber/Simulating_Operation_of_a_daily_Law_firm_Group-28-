# Project Organization Guide

This document explains how the Law Firm Management System project is organized and how to work with it effectively.

## 📁 Project Structure Overview

```
law-firm-management/
├── .gitignore                 # Git ignore rules
├── pom.xml                    # Maven configuration
├── README.md                  # Main documentation
├── PROJECT_ORGANIZATION.md    # This file
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── lawfirm/
│   │   │           ├── LawFirmApplication.java    # Main entry point
│   │   │           │
│   │   │           ├── controllers/                # All controllers
│   │   │           │   ├── LoginController.java
│   │   │           │   ├── LawyerDashboardController.java
│   │   │           │   ├── ResearcherDashboardController.java
│   │   │           │   ├── lawyer/                # 8 lawyer controllers
│   │   │           │   └── researcher/            # 8 researcher controllers
│   │   │           │
│   │   │           ├── models/                    # Data models
│   │   │           │   ├── User.java
│   │   │           │   ├── Lawyer.java
│   │   │           │   ├── LegalResearcher.java
│   │   │           │   ├── CaseFile.java
│   │   │           │   ├── Client.java
│   │   │           │   ├── ResearchRecord.java
│   │   │           │   ├── Precedent.java
│   │   │           │   ├── Document.java
│   │   │           │   └── Billing.java
│   │   │           │
│   │   │           └── utils/                     # Utility classes
│   │   │               ├── DataStorage.java       # Data management
│   │   │               └── PageNavigator.java    # Navigation helper
│   │   │
│   │   └── resources/
│   │       └── fxml/                              # All FXML UI files
│   │           ├── LoginPage.fxml
│   │           ├── LawyerDashboard.fxml
│   │           ├── ResearcherDashboard.fxml
│   │           ├── lawyer/                        # 8 lawyer FXML files
│   │           └── researcher/                    # 8 researcher FXML files
│   │
│   └── test/                                      # Test files (future)
│       └── java/
│
└── target/                                        # Compiled files (auto-generated)
```

## 🎯 Package Organization Strategy

### 1. **Controllers Package** (`com.lawfirm.controllers`)
   - **Purpose**: Handle user interactions and UI logic
   - **Organization**:
     - Main controllers (Login, Dashboards) at root level
     - Role-specific controllers in sub-packages (`lawyer/`, `researcher/`)
   - **Naming Convention**: `[PageName]Controller.java`

### 2. **Models Package** (`com.lawfirm.models`)
   - **Purpose**: Data structures and business entities
   - **Organization**: All models at the same level
   - **Naming Convention**: Singular nouns (e.g., `CaseFile`, not `CaseFiles`)

### 3. **Utils Package** (`com.lawfirm.utils`)
   - **Purpose**: Reusable utility classes
   - **Current Utilities**:
     - `DataStorage`: Singleton for data management
     - `PageNavigator`: Navigation helper

### 4. **Resources Package** (`src/main/resources/fxml`)
   - **Purpose**: UI layout files (FXML)
   - **Organization**: Mirrors controller structure
   - **Naming Convention**: `[PageName]Page.fxml` or `[PageName].fxml`

## 🔧 IntelliJ IDEA Setup

### Step 1: Mark Directories Correctly

1. **Right-click** on `src/main/java` → **Mark Directory as** → **Sources Root**
2. **Right-click** on `src/main/resources` → **Mark Directory as** → **Resources Root**
3. **Right-click** on `src/test/java` → **Mark Directory as** → **Test Sources Root** (if exists)

### Step 2: Configure Project Structure

1. Go to **File** → **Project Structure** (or `Cmd+;` on Mac / `Ctrl+Alt+Shift+S` on Windows)
2. Under **Project**:
   - Set **Project SDK**: Java 11 or higher
   - Set **Project language level**: 11 or higher
3. Under **Modules**:
   - Ensure `src/main/java` is marked as **Sources**
   - Ensure `src/main/resources` is marked as **Resources**

### Step 3: Configure JavaFX

1. Go to **File** → **Settings** → **Languages & Frameworks** → **JavaFX**
2. Set **Path to SceneBuilder**: (if you have Scene Builder installed)
   - macOS: `/Applications/JavaFX Scene Builder.app`
   - Windows: `C:\Program Files\JavaFX Scene Builder\JavaFX Scene Builder.exe`
   - Linux: `/opt/scenebuilder/JavaFX Scene Builder`

### Step 4: Maven Configuration

1. **Right-click** on `pom.xml` → **Maven** → **Reload Project**
2. Wait for dependencies to download
3. Verify in **View** → **Tool Windows** → **Maven** that all dependencies are resolved

### Step 5: Run Configuration

1. **Right-click** on `LawFirmApplication.java`
2. Select **Run 'LawFirmApplication.main()'**
3. IntelliJ will create a run configuration automatically

## 📝 File Naming Conventions

### Java Files
- **Controllers**: `[PageName]Controller.java`
  - Example: `CreateCaseController.java`, `LoginController.java`
- **Models**: `[EntityName].java`
  - Example: `CaseFile.java`, `User.java`
- **Utils**: `[UtilityName].java`
  - Example: `DataStorage.java`, `PageNavigator.java`

### FXML Files
- **Pages**: `[PageName]Page.fxml` or `[PageName].fxml`
  - Example: `CreateCasePage.fxml`, `LoginPage.fxml`
- **Dashboards**: `[Role]Dashboard.fxml`
  - Example: `LawyerDashboard.fxml`, `ResearcherDashboard.fxml`

## 🔄 Workflow Organization

### Adding a New Page

1. **Create FXML File**:
   - Location: `src/main/resources/fxml/[role]/[PageName]Page.fxml`
   - Design in Scene Builder or manually

2. **Create Controller**:
   - Location: `src/main/java/com/lawfirm/controllers/[role]/[PageName]Controller.java`
   - Implement `@FXML` methods

3. **Add Navigation**:
   - Update dashboard controller with navigation method
   - Use `PageNavigator.navigateTo("/fxml/[path]")`

4. **Update Data Models** (if needed):
   - Add new fields to models in `models/` package
   - Update `DataStorage` if new data types

### Modifying Existing Pages

1. **UI Changes**: Edit FXML file in Scene Builder or text editor
2. **Logic Changes**: Edit corresponding controller
3. **Data Changes**: Update models and `DataStorage` class

## 📊 Code Organization Best Practices

### 1. **Separation of Concerns**
   - **Controllers**: Only handle UI events and navigation
   - **Models**: Only contain data and simple getters/setters
   - **Utils**: Reusable business logic

### 2. **Package Visibility**
   - Keep related classes together
   - Use sub-packages for role-specific code
   - Avoid deep nesting (max 3-4 levels)

### 3. **Resource Management**
   - All FXML files in `resources/fxml/`
   - Keep FXML structure matching controller structure
   - Use relative paths in `PageNavigator`

### 4. **Data Flow**
   ```
   User Action → Controller → DataStorage → Model → Controller → UI Update
   ```

## 🗂️ Directory Organization Tips

### For Better Navigation in IntelliJ:

1. **Use Project View** (`Cmd+1`):
   - Shows actual file structure
   - Best for navigating packages

2. **Use Package View**:
   - Groups files by package
   - Collapses empty directories
   - Better for understanding structure

3. **Use Scratches**:
   - For temporary code snippets
   - **File** → **New** → **Scratch File**

### File Grouping:

- **Group by Type**: IntelliJ can group files by type
  - **Right-click** in Project View → **Group by** → **File Type**
- **Sort by**: Name, Type, or Modification Time

## 🎨 Scene Builder Organization

### When Using Scene Builder:

1. **Open FXML**: Right-click `.fxml` file → **Open in Scene Builder**
2. **Component Hierarchy**: Organize components logically
   - Use containers (VBox, HBox, GridPane) for layout
   - Group related components
3. **Controller Class**: Set in Scene Builder
   - **View** → **Show Sample Controller Skeleton**
   - Copy to your controller file

## 📦 Maven Organization

### Dependencies:
- All in `pom.xml`
- Grouped by purpose (JavaFX, testing, etc.)
- Version managed in `<properties>`

### Build Output:
- Compiled classes: `target/classes/`
- Test classes: `target/test-classes/`
- JAR files: `target/` (if configured)

## 🔍 Finding Files Quickly

### IntelliJ Shortcuts:

- **Navigate to File**: `Cmd+Shift+O` (Mac) / `Ctrl+Shift+N` (Windows)
- **Navigate to Class**: `Cmd+O` (Mac) / `Ctrl+N` (Windows)
- **Navigate to Symbol**: `Cmd+Alt+O` (Mac) / `Ctrl+Alt+Shift+N` (Windows)
- **Recent Files**: `Cmd+E` (Mac) / `Ctrl+E` (Windows)
- **Go to Declaration**: `Cmd+B` (Mac) / `Ctrl+B` (Windows)

## ✅ Checklist for New Developers

- [ ] Project opened in IntelliJ IDEA
- [ ] Maven dependencies downloaded
- [ ] Source/resource directories marked correctly
- [ ] JavaFX Scene Builder configured (optional)
- [ ] Application runs successfully
- [ ] Can navigate between pages
- [ ] Understand package structure
- [ ] Know where to add new features

## 🚀 Quick Reference

| Task | Location |
|------|----------|
| Add new lawyer page | `controllers/lawyer/` + `resources/fxml/lawyer/` |
| Add new researcher page | `controllers/researcher/` + `resources/fxml/researcher/` |
| Modify data models | `models/` package |
| Change navigation | `utils/PageNavigator.java` |
| Update data storage | `utils/DataStorage.java` |
| Main application entry | `LawFirmApplication.java` |

---

**Remember**: Keep related files together, use consistent naming, and maintain the separation between UI (FXML), logic (Controllers), and data (Models).

