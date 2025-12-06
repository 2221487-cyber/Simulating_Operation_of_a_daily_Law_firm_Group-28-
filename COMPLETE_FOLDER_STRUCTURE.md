# Complete Project Folder Structure

This document shows the complete folder structure with all files in the Law Firm Management System.

## 📁 Full Directory Tree

```
law-firm-management/
│
├── 📄 .gitignore                          # Git ignore rules
├── 📄 pom.xml                             # Maven configuration
├── 📄 README.md                           # Main documentation
├── 📄 PROJECT_ORGANIZATION.md             # Organization guide
├── 📄 SETUP_CHECKLIST.md                  # Setup checklist
├── 📄 QUICK_START.md                      # Quick start guide
├── 📄 COMPLETE_FOLDER_STRUCTURE.md        # This file
│
├── 📁 .idea/                              # IntelliJ IDEA settings
│   ├── codeStyles/
│   │   └── codeStyleConfig.xml
│   └── misc.xml
│
├── 📁 src/
│   │
│   ├── 📁 main/
│   │   │
│   │   ├── 📁 java/
│   │   │   └── 📁 com/
│   │   │       └── 📁 lawfirm/
│   │   │           │
│   │   │           ├── 📄 LawFirmApplication.java
│   │   │           │
│   │   │           ├── 📁 controllers/
│   │   │           │   │
│   │   │           │   ├── 📄 LoginController.java
│   │   │           │   ├── 📄 LawyerDashboardController.java
│   │   │           │   ├── 📄 ResearcherDashboardController.java
│   │   │           │   │
│   │   │           │   ├── 📁 lawyer/
│   │   │           │   │   ├── 📄 CreateCaseController.java
│   │   │           │   │   ├── 📄 UpdateCaseStatusController.java
│   │   │           │   │   ├── 📄 ManageHearingDatesController.java
│   │   │           │   │   ├── 📄 UploadDocumentsController.java
│   │   │           │   │   ├── 📄 ViewClientDetailsController.java
│   │   │           │   │   ├── 📄 GenerateCaseReportController.java
│   │   │           │   │   ├── 📄 TrackBillingController.java
│   │   │           │   │   └── 📄 CloseCaseController.java
│   │   │           │   │
│   │   │           │   └── 📁 researcher/
│   │   │           │       ├── 📄 CreateResearchRecordController.java
│   │   │           │       ├── 📄 SearchPrecedentsController.java
│   │   │           │       ├── 📄 SavePrecedentController.java
│   │   │           │       ├── 📄 GenerateResearchSummaryController.java
│   │   │           │       ├── 📄 ComparePrecedentsController.java
│   │   │           │       ├── 📄 ExportResearchReportController.java
│   │   │           │       ├── 📄 EditResearchRecordController.java
│   │   │           │       └── 📄 ViewResearchHistoryController.java
│   │   │           │
│   │   │           ├── 📁 models/
│   │   │           │   ├── 📄 User.java
│   │   │           │   ├── 📄 Lawyer.java
│   │   │           │   ├── 📄 LegalResearcher.java
│   │   │           │   ├── 📄 CaseFile.java
│   │   │           │   ├── 📄 Client.java
│   │   │           │   ├── 📄 ResearchRecord.java
│   │   │           │   ├── 📄 Precedent.java
│   │   │           │   ├── 📄 Document.java
│   │   │           │   └── 📄 Billing.java
│   │   │           │
│   │   │           └── 📁 utils/
│   │   │               ├── 📄 DataStorage.java
│   │   │               └── 📄 PageNavigator.java
│   │   │
│   │   └── 📁 resources/
│   │       └── 📁 fxml/
│   │           │
│   │           ├── 📄 LoginPage.fxml
│   │           ├── 📄 LawyerDashboard.fxml
│   │           ├── 📄 ResearcherDashboard.fxml
│   │           │
│   │           ├── 📁 lawyer/
│   │           │   ├── 📄 CreateCasePage.fxml
│   │           │   ├── 📄 UpdateCaseStatusPage.fxml
│   │           │   ├── 📄 ManageHearingDatesPage.fxml
│   │           │   ├── 📄 UploadDocumentsPage.fxml
│   │           │   ├── 📄 ViewClientDetailsPage.fxml
│   │           │   ├── 📄 GenerateCaseReportPage.fxml
│   │           │   ├── 📄 TrackBillingPage.fxml
│   │           │   └── 📄 CloseCasePage.fxml
│   │           │
│   │           └── 📁 researcher/
│   │               ├── 📄 CreateResearchRecordPage.fxml
│   │               ├── 📄 SearchPrecedentsPage.fxml
│   │               ├── 📄 SavePrecedentPage.fxml
│   │               ├── 📄 GenerateResearchSummaryPage.fxml
│   │               ├── 📄 ComparePrecedentsPage.fxml
│   │               ├── 📄 ExportResearchReportPage.fxml
│   │               ├── 📄 EditResearchRecordPage.fxml
│   │               └── 📄 ViewResearchHistoryPage.fxml
│   │
│   └── 📁 test/                           # For future test files
│       └── 📁 java/
│
└── 📁 target/                             # Auto-generated build output
    ├── 📁 classes/
    └── 📁 test-classes/
```

## 📊 File Count Summary

### Java Files (19 total)
- **Main Application**: 1 file
  - `LawFirmApplication.java`
  
- **Controllers**: 18 files
  - Main controllers: 3 files
  - Lawyer controllers: 8 files
  - Researcher controllers: 8 files
  
- **Models**: 9 files
  - `User.java`, `Lawyer.java`, `LegalResearcher.java`
  - `CaseFile.java`, `Client.java`, `ResearchRecord.java`
  - `Precedent.java`, `Document.java`, `Billing.java`
  
- **Utils**: 2 files
  - `DataStorage.java`, `PageNavigator.java`

### FXML Files (19 total)
- **Main pages**: 3 files
  - `LoginPage.fxml`, `LawyerDashboard.fxml`, `ResearcherDashboard.fxml`
  
- **Lawyer pages**: 8 files
  - All in `fxml/lawyer/` directory
  
- **Researcher pages**: 8 files
  - All in `fxml/researcher/` directory

### Configuration Files
- `pom.xml` - Maven configuration
- `.gitignore` - Git ignore rules
- `.idea/` - IntelliJ IDEA settings

### Documentation Files
- `README.md` - Main documentation
- `PROJECT_ORGANIZATION.md` - Organization guide
- `SETUP_CHECKLIST.md` - Setup checklist
- `QUICK_START.md` - Quick start guide
- `COMPLETE_FOLDER_STRUCTURE.md` - This file

## 📂 Detailed File List

### Java Source Files (`src/main/java/com/lawfirm/`)

#### Root Level
```
LawFirmApplication.java
```

#### Controllers (`controllers/`)
```
LoginController.java
LawyerDashboardController.java
ResearcherDashboardController.java
```

#### Lawyer Controllers (`controllers/lawyer/`)
```
CreateCaseController.java
UpdateCaseStatusController.java
ManageHearingDatesController.java
UploadDocumentsController.java
ViewClientDetailsController.java
GenerateCaseReportController.java
TrackBillingController.java
CloseCaseController.java
```

#### Researcher Controllers (`controllers/researcher/`)
```
CreateResearchRecordController.java
SearchPrecedentsController.java
SavePrecedentController.java
GenerateResearchSummaryController.java
ComparePrecedentsController.java
ExportResearchReportController.java
EditResearchRecordController.java
ViewResearchHistoryController.java
```

#### Models (`models/`)
```
User.java
Lawyer.java
LegalResearcher.java
CaseFile.java
Client.java
ResearchRecord.java
Precedent.java
Document.java
Billing.java
```

#### Utils (`utils/`)
```
DataStorage.java
PageNavigator.java
```

### FXML Files (`src/main/resources/fxml/`)

#### Root Level
```
LoginPage.fxml
LawyerDashboard.fxml
ResearcherDashboard.fxml
```

#### Lawyer Pages (`fxml/lawyer/`)
```
CreateCasePage.fxml
UpdateCaseStatusPage.fxml
ManageHearingDatesPage.fxml
UploadDocumentsPage.fxml
ViewClientDetailsPage.fxml
GenerateCaseReportPage.fxml
TrackBillingPage.fxml
CloseCasePage.fxml
```

#### Researcher Pages (`fxml/researcher/`)
```
CreateResearchRecordPage.fxml
SearchPrecedentsPage.fxml
SavePrecedentPage.fxml
GenerateResearchSummaryPage.fxml
ComparePrecedentsPage.fxml
ExportResearchReportPage.fxml
EditResearchRecordPage.fxml
ViewResearchHistoryPage.fxml
```

## 🔗 File Relationships

### Controller ↔ FXML Mapping

#### Lawyer Pages
| Controller | FXML File |
|------------|-----------|
| `CreateCaseController.java` | `CreateCasePage.fxml` |
| `UpdateCaseStatusController.java` | `UpdateCaseStatusPage.fxml` |
| `ManageHearingDatesController.java` | `ManageHearingDatesPage.fxml` |
| `UploadDocumentsController.java` | `UploadDocumentsPage.fxml` |
| `ViewClientDetailsController.java` | `ViewClientDetailsPage.fxml` |
| `GenerateCaseReportController.java` | `GenerateCaseReportPage.fxml` |
| `TrackBillingController.java` | `TrackBillingPage.fxml` |
| `CloseCaseController.java` | `CloseCasePage.fxml` |

#### Researcher Pages
| Controller | FXML File |
|------------|-----------|
| `CreateResearchRecordController.java` | `CreateResearchRecordPage.fxml` |
| `SearchPrecedentsController.java` | `SearchPrecedentsPage.fxml` |
| `SavePrecedentController.java` | `SavePrecedentPage.fxml` |
| `GenerateResearchSummaryController.java` | `GenerateResearchSummaryPage.fxml` |
| `ComparePrecedentsController.java` | `ComparePrecedentsPage.fxml` |
| `ExportResearchReportController.java` | `ExportResearchReportPage.fxml` |
| `EditResearchRecordController.java` | `EditResearchRecordPage.fxml` |
| `ViewResearchHistoryController.java` | `ViewResearchHistoryPage.fxml` |

### Model Usage

#### Used by Lawyer Controllers
- `CaseFile.java` - Used by all lawyer controllers
- `Client.java` - Used by CreateCase, ViewClientDetails
- `Document.java` - Used by UploadDocuments
- `Billing.java` - Used by TrackBilling

#### Used by Researcher Controllers
- `ResearchRecord.java` - Used by all researcher controllers
- `Precedent.java` - Used by SearchPrecedents, SavePrecedent, ComparePrecedents

#### Base Models
- `User.java` - Base class for Lawyer and LegalResearcher
- `Lawyer.java` - Extends User
- `LegalResearcher.java` - Extends User

## 📍 File Locations Reference

### To Find a Controller:
```
src/main/java/com/lawfirm/controllers/[role]/[PageName]Controller.java
```

### To Find an FXML File:
```
src/main/resources/fxml/[role]/[PageName]Page.fxml
```

### To Find a Model:
```
src/main/java/com/lawfirm/models/[ModelName].java
```

### To Find a Utility:
```
src/main/java/com/lawfirm/utils/[UtilityName].java
```

## ✅ Verification Checklist

Use this to verify all files exist:

- [ ] 1 Main Application file
- [ ] 3 Main controllers (Login, LawyerDashboard, ResearcherDashboard)
- [ ] 8 Lawyer controllers
- [ ] 8 Researcher controllers
- [ ] 9 Model classes
- [ ] 2 Utility classes
- [ ] 3 Main FXML files
- [ ] 8 Lawyer FXML files
- [ ] 8 Researcher FXML files
- [ ] Configuration files (pom.xml, .gitignore)
- [ ] Documentation files

**Total: 38 Java files + 19 FXML files = 57 source files**

---

**Note**: The `target/` directory is auto-generated by Maven and contains compiled `.class` files. You don't need to manage it manually.

