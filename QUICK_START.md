# Quick Start Guide - Project Organization

## 🎯 How to Organize Your Workflow

### Step 1: Open Project in IntelliJ IDEA

1. **File** → **Open** → Select project folder
2. IntelliJ will detect Maven project automatically
3. Wait for indexing to complete

### Step 2: Verify Project Structure

**In IntelliJ Project View (`Cmd+1`):**

```
📁 law-firm-management
├── 📄 pom.xml
├── 📄 README.md
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 com.lawfirm
│   │   │       ├── 🎯 LawFirmApplication.java
│   │   │       ├── 📁 controllers
│   │   │       ├── 📁 models
│   │   │       └── 📁 utils
│   │   └── 📁 resources
│   │       └── 📁 fxml
└── 📁 target (auto-generated)
```

### Step 3: Mark Directories (CRITICAL!)

**Right-click each folder:**

1. `src/main/java` → **Mark Directory as** → **Sources Root** ✅
2. `src/main/resources` → **Mark Directory as** → **Resources Root** ✅

### Step 4: Load Maven Dependencies

1. **Right-click** `pom.xml`
2. **Maven** → **Reload Project**
3. Wait for download (check bottom status bar)

### Step 5: Run the Application

1. Open `LawFirmApplication.java`
2. **Right-click** → **Run 'LawFirmApplication.main()'**
3. Application window should open!

---

## 📂 Understanding the Organization

### **Controllers** = Logic & User Interaction
```
controllers/
├── LoginController.java          ← Handles login
├── LawyerDashboardController.java ← Lawyer's main page
├── ResearcherDashboardController.java ← Researcher's main page
├── lawyer/                       ← 8 lawyer feature pages
│   ├── CreateCaseController.java
│   ├── UpdateCaseStatusController.java
│   └── ... (6 more)
└── researcher/                   ← 8 researcher feature pages
    ├── CreateResearchRecordController.java
    ├── SearchPrecedentsController.java
    └── ... (6 more)
```

### **Models** = Data Structures
```
models/
├── User.java              ← Base user class
├── Lawyer.java           ← Lawyer-specific data
├── LegalResearcher.java   ← Researcher-specific data
├── CaseFile.java          ← Case information
├── Client.java            ← Client information
├── ResearchRecord.java    ← Research data
├── Precedent.java         ← Legal precedents
├── Document.java          ← Document metadata
└── Billing.java           ← Billing information
```

### **FXML** = User Interface Design
```
resources/fxml/
├── LoginPage.fxml
├── LawyerDashboard.fxml
├── ResearcherDashboard.fxml
├── lawyer/                ← 8 lawyer UI pages
│   ├── CreateCasePage.fxml
│   └── ... (7 more)
└── researcher/            ← 8 researcher UI pages
    ├── CreateResearchRecordPage.fxml
    └── ... (7 more)
```

### **Utils** = Helper Classes
```
utils/
├── DataStorage.java       ← Manages all data (singleton)
└── PageNavigator.java     ← Handles page navigation
```

---

## 🔄 How Things Connect

### Navigation Flow:
```
Login Page
    ↓ (authenticate)
Dashboard (Lawyer OR Researcher)
    ↓ (click button)
Feature Page (1 of 8)
    ↓ (back button)
Dashboard
    ↓ (logout)
Login Page
```

### Data Flow:
```
User Input → Controller → DataStorage → Model → Controller → UI Update
```

### File Relationships:
```
FXML File ←→ Controller ←→ Model ←→ DataStorage
   UI          Logic        Data      Storage
```

---

## 🎨 Working with Scene Builder

### To Edit UI:

1. **Right-click** any `.fxml` file
2. **Open in Scene Builder**
3. Make visual changes
4. **Save** (Ctrl+S / Cmd+S)
5. Changes appear in IntelliJ automatically

### Scene Builder Tips:
- **Left Panel**: Component library
- **Center**: Visual design area
- **Right Panel**: Properties & hierarchy
- **Bottom**: Controller code preview

---

## 📝 Common Tasks

### Add a New Button to Dashboard:

1. **Open FXML**: `LawyerDashboard.fxml` (or Researcher)
2. **Add Button** in Scene Builder
3. **Set fx:id**: `newButton`
4. **Set onAction**: `handleNewAction`
5. **Open Controller**: `LawyerDashboardController.java`
6. **Add Method**:
   ```java
   @FXML
   private void handleNewAction() {
       PageNavigator.navigateTo("/fxml/lawyer/NewPage.fxml");
   }
   ```

### Create a New Page:

1. **Create FXML**: `resources/fxml/lawyer/NewPage.fxml`
2. **Create Controller**: `controllers/lawyer/NewPageController.java`
3. **Link in FXML**: Set `fx:controller="com.lawfirm.controllers.lawyer.NewPageController"`
4. **Add Navigation**: Add button/method in dashboard

### Modify Data Model:

1. **Open Model**: e.g., `CaseFile.java`
2. **Add Field**: 
   ```java
   private String newField;
   ```
3. **Add Getter/Setter**
4. **Update DataStorage** if needed

---

## 🗂️ IntelliJ View Modes

### Project View (`Cmd+1`):
- Shows actual file structure
- Best for: Finding files, understanding structure

### Package View:
- Groups by package
- Best for: Understanding code organization

### Structure View (`Cmd+7`):
- Shows class structure
- Best for: Navigating within a file

### Navigation Bar (`Alt+Home`):
- Breadcrumb navigation
- Best for: Quick navigation

---

## 🔍 Finding Things Quickly

### Keyboard Shortcuts:

| Action | Mac | Windows |
|--------|-----|---------|
| Find File | `Cmd+Shift+O` | `Ctrl+Shift+N` |
| Find Class | `Cmd+O` | `Ctrl+N` |
| Recent Files | `Cmd+E` | `Ctrl+E` |
| Go to Declaration | `Cmd+B` | `Ctrl+B` |
| Search Everywhere | `Shift+Shift` | `Shift+Shift` |

### Search Tips:
- **Double Shift**: Search everywhere (files, classes, symbols)
- **Cmd+Shift+F**: Find in all files
- **Cmd+F**: Find in current file

---

## ✅ Organization Checklist

- [ ] Project opens without errors
- [ ] All directories marked correctly
- [ ] Maven dependencies loaded
- [ ] Application runs
- [ ] Can navigate between pages
- [ ] Scene Builder opens FXML files
- [ ] Understand file structure
- [ ] Know where to add new features

---

## 🚀 Next Steps

1. **Explore**: Click through all pages
2. **Test**: Try creating cases, research records
3. **Customize**: Edit FXML files to match your design
4. **Extend**: Add new features as needed
5. **Document**: Add comments to your code

---

**Remember**: 
- **FXML** = What you see (UI)
- **Controller** = What happens (Logic)
- **Model** = What's stored (Data)
- **Utils** = Helper functions

Keep them separate and organized! 🎯

