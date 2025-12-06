# Setup Checklist for Law Firm Management System

Use this checklist to ensure your project is properly organized and ready to use.

## ✅ Initial Setup

### 1. IntelliJ IDEA Configuration
- [ ] Project opened in IntelliJ IDEA
- [ ] `src/main/java` marked as **Sources Root**
- [ ] `src/main/resources` marked as **Resources Root**
- [ ] Project SDK set to Java 11 or higher
- [ ] Language level set to 11 or higher

### 2. Maven Setup
- [ ] Maven project recognized by IntelliJ
- [ ] `pom.xml` reloaded (Right-click → Maven → Reload Project)
- [ ] All dependencies downloaded (check Maven tool window)
- [ ] No dependency errors in `pom.xml`

### 3. JavaFX Configuration
- [ ] JavaFX dependencies resolved
- [ ] Scene Builder configured (optional but recommended)
  - [ ] Path to Scene Builder set in Settings
  - [ ] Can open FXML files in Scene Builder

### 4. Project Structure Verification
- [ ] All controllers exist in correct packages
- [ ] All FXML files exist in correct directories
- [ ] All model classes present
- [ ] Utility classes present

## ✅ File Organization Check

### Controllers
- [ ] `LoginController.java` exists
- [ ] `LawyerDashboardController.java` exists
- [ ] `ResearcherDashboardController.java` exists
- [ ] 8 lawyer controllers in `controllers/lawyer/`
- [ ] 8 researcher controllers in `controllers/researcher/`

### FXML Files
- [ ] `LoginPage.fxml` exists
- [ ] `LawyerDashboard.fxml` exists
- [ ] `ResearcherDashboard.fxml` exists
- [ ] 8 lawyer FXML files in `resources/fxml/lawyer/`
- [ ] 8 researcher FXML files in `resources/fxml/researcher/`

### Models
- [ ] `User.java` exists
- [ ] `Lawyer.java` exists
- [ ] `LegalResearcher.java` exists
- [ ] `CaseFile.java` exists
- [ ] `Client.java` exists
- [ ] `ResearchRecord.java` exists
- [ ] `Precedent.java` exists
- [ ] `Document.java` exists
- [ ] `Billing.java` exists

### Utilities
- [ ] `DataStorage.java` exists
- [ ] `PageNavigator.java` exists

## ✅ Build & Run

### Compilation
- [ ] Project builds without errors
  - **Build** → **Build Project** (`Cmd+F9` / `Ctrl+F9`)
- [ ] No compilation errors
- [ ] No warnings (or acceptable warnings)

### Execution
- [ ] Application runs successfully
- [ ] Login page displays correctly
- [ ] Can login as lawyer
- [ ] Can login as researcher
- [ ] Dashboards display correctly
- [ ] Navigation works between pages

## ✅ Functionality Test

### Login & Navigation
- [ ] Login with lawyer credentials works
- [ ] Login with researcher credentials works
- [ ] Invalid credentials show error
- [ ] Logout returns to login page
- [ ] Back buttons return to dashboard

### Lawyer Features (Test each page)
- [ ] Create New Case File - form works
- [ ] Update Case Status - can select and update
- [ ] Manage Hearing Dates - date picker works
- [ ] Upload Case Documents - can add documents
- [ ] View Client Details - displays client info
- [ ] Generate Case Progress Report - generates report
- [ ] Track Billing and Payments - billing works
- [ ] Close Case - can close cases

### Researcher Features (Test each page)
- [ ] Create Research Record - form works
- [ ] Search Legal Precedents - search works
- [ ] Save Precedent to Library - can save
- [ ] Generate Research Summary - can edit summary
- [ ] Compare Two Precedents - comparison works
- [ ] Export Research Report - report generates
- [ ] Edit Previous Research Record - can edit
- [ ] View Research History - table displays

## ✅ Code Quality

### Linting
- [ ] No linter errors
- [ ] No unused imports
- [ ] No unused variables
- [ ] Code follows naming conventions

### Structure
- [ ] Controllers properly organized
- [ ] Models properly structured
- [ ] Utilities are reusable
- [ ] FXML files match controller structure

## ✅ Documentation

- [ ] README.md is complete
- [ ] PROJECT_ORGANIZATION.md is reviewed
- [ ] Code comments are present where needed
- [ ] Setup instructions are clear

## ✅ Git Setup (Optional)

- [ ] `.gitignore` file created
- [ ] Git repository initialized (if using version control)
- [ ] Initial commit made
- [ ] Remote repository set up (if applicable)

## 🎯 Quick Test Commands

### In IntelliJ Terminal:
```bash
# Build project
mvn clean compile

# Run application
mvn javafx:run

# Check for errors
mvn validate
```

### Verify Structure:
```bash
# Count Java files
find src/main/java -name "*.java" | wc -l
# Should show: 19 files (1 main + 18 controllers)

# Count FXML files
find src/main/resources/fxml -name "*.fxml" | wc -l
# Should show: 19 files (3 main + 16 goal pages)
```

## 📋 Default Credentials Reminder

**Lawyer:**
- Email: `lawyer@lawfirm.com`
- Password: `password`

**Researcher:**
- Email: `researcher@lawfirm.com`
- Password: `password`

## 🐛 Common Issues & Solutions

### Issue: FXML files not found
- ✅ Check that `resources` is marked as Resources Root
- ✅ Verify file paths in controllers match actual locations
- ✅ Ensure FXML files are in `src/main/resources/fxml/`

### Issue: JavaFX not working
- ✅ Verify JavaFX dependencies in `pom.xml`
- ✅ Check Java version (needs 11+)
- ✅ Rebuild project

### Issue: Scene Builder not opening
- ✅ Verify Scene Builder installation path
- ✅ Check IntelliJ Scene Builder settings
- ✅ Try opening Scene Builder manually first

### Issue: Navigation not working
- ✅ Check `PageNavigator` class
- ✅ Verify FXML paths start with `/fxml/`
- ✅ Ensure primary stage is set

## ✨ Next Steps After Setup

1. **Explore the Code**: Review controllers and models
2. **Test All Features**: Go through each page
3. **Customize UI**: Edit FXML files in Scene Builder
4. **Add Features**: Extend functionality as needed
5. **Add Persistence**: Implement file/database storage

---

**Status**: Check off items as you complete them. Once all items are checked, your project is fully organized and ready to use!

